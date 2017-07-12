package net.thegaminghuskymc.futopia.blocks;

public interface IInitializer
{

    public abstract boolean preInit();

    public abstract boolean initialize();

    public abstract boolean postInit();
}