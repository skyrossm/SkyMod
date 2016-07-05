package com.skyrossm.skymod.network;

import com.skyrossm.skymod.network.message.PacketSuperRing;
import com.skyrossm.skymod.reference.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init(){
        INSTANCE.registerMessage(PacketSuperRing.ServerHandler.class, PacketSuperRing.class, 0, Side.SERVER);
        INSTANCE.registerMessage(PacketSuperRing.ClientHandler.class, PacketSuperRing.class, 1, Side.CLIENT);
    }
}
