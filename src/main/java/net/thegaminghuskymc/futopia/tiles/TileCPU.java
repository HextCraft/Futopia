/*
 * This file is part of Blue Power. Blue Power is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. Blue Power is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along
 * with Blue Power. If not, see <http://www.gnu.org/licenses/>
 */
package net.thegaminghuskymc.futopia.tiles;

import java.io.IOException;
import java.io.InputStream;

import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.thegaminghuskymc.futopia.Futopia;

/**
 * @author fabricator77
 */
public class TileCPU extends TileBase implements IRedBusWindow {

    public int cpuStoredCycles = 100000;
    public int cpuForTickCycles = 1;

    public byte deviceID = 0;
    public byte screenID = 1;
    public byte discDriveID = 2;
    public boolean halt = false;
    public int rtc = 0;
    private byte[] memory;

    private int reg_X;
    private int reg_A;
    private int reg_D;
    private int reg_I;
    private int reg_R;

    private int redbus_remote_address;
    private Object redbus_cache;
    public TileCPU() {
        this.memory = new byte[8192];
        powerOnReset();
    }

    public void powerOnReset() {
        reg_R = 768;
        this.memory[0] = this.discDriveID;
        this.memory[1] = this.screenID;
        this.memory[2] = redbus_id;
        boolean preloadRam = true;
        if (preloadRam) {
            preLoadRAM();
            return;
        }


        String bootLoader = "/assets/bluepower/software/rpcboot.bin";
        InputStream disc = Futopia.class.getResourceAsStream(bootLoader);

        if (disc == null) {
            Futopia.LOGGER.info("[BluePowerControl] CPU failed to load bootloader " + bootLoader);
            return;
        }

        try {
            Futopia.LOGGER.info("[BluePowerControl] CPU loaded bootloader " + bootLoader);
            disc.read(this.memory, 1024, 256);
            disc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preLoadRAM() {
        this.memory[1024] = (byte) 0xDB; // STP
    }

    public void opSTP() {// 65EL02 modified
        halt = true;
        Futopia.LOGGER.info("self block=" + this.blockType);
        if (this.world.isAirBlock(this.getPos())) {
            //set CPU on fire for the lolz
            this.world.playSound((double) this.getPos().getX() + 0.5D, (double) this.getPos().getY() + 0.5D, (double) this.getPos().getZ() + 0.5D, SoundEvent.REGISTRY.getObject(null), SoundCategory.BLOCKS, 20F, 10F, false);
        }
    }

    public void opTRX() {// 65EL02
        // TRX opcode
        // tranfer R to X
        this.reg_X = this.reg_R;
    }

    public void opTXR() {// 65EL02
        // TXR opcode
        // transfer X to R
        this.reg_R = this.reg_X;
    }

    public void opTAD() {// 65EL02
        // 65LE02 TAD
        // transfer A to D
        this.reg_D = this.reg_A;
    }

    public void opTDA() {
        // 65EL02 TDA
        this.reg_A = this.reg_D;
    }

    public void opTIX() {
        // 65EL02 TIX
        this.reg_X = this.reg_I;
    }

    public void opTXI() {
        // 65EL02 TXI
        this.reg_I = this.reg_X;
    }


    public void opMMU(int mode) {
        switch (mode) {
            case 0:
                // set remote redbus address
                int t = this.reg_A & 0xFF;
                if (t != this.redbus_remote_address) {
                    // if output buffer full
                    if (this.redbus_cache != null) {
                    }
                    this.redbus_remote_address = t;
                }
                break;
            case 1:
                // set redbus window to memory address in A
                break;
            case 2:
			break;
            case 3:
                // set external memory mapped window to A.
                break;
            case 4:
                // enable external memory mapped window
                break;
            case 5:
                // set BRK address to A
                break;
            case 6:
                // set POR address to A
                break;

            case 0x80:
                // get remote redbus address
                this.reg_A = this.redbus_remote_address;
                break;
            case 0x81:
                // get redbus window to memory address in A
                break;
            case 0x82:
			break;
            case 0x83:
                // get external memory mapped window to A.
                break;
            case 0x84:
                // disable external memory mapped window
                break;
            case 0x85:
                // get BRK address to A
                break;
            case 0x86:
                // get POR address to A
                break;
            case 0x87:
                // get RTC to A and D
                this.reg_A = (this.rtc & 0xFFFF);
                this.reg_D = (this.rtc >> 16 & 0xFFFF);
                break;
            case 0xFF:
                // Output A register to MC logfile.
                break;
        }
    }

    /**
     * Given two bytes, return a 16 bit address.
     */
    int sixteenBitAddress(int lowByte, int hiByte) {

        return ((hiByte << 8) | lowByte) & 0xffff;
    }

    public enum AddressMode {
        ABSOLUTE, INDIRECT, RELATIVE, ZEROPAGE
    }
}

