package com.skyrossm.skymod.network.message;

import com.skyrossm.skymod.SkyMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSuperRing implements IMessage {
	private String text;
	
	public PacketSuperRing() {}
	public PacketSuperRing(String string) {
		text = string;
	}
	
	@Override
    public void fromBytes(ByteBuf buf) {
        text = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, text);
    }

    public static class ServerHandler implements IMessageHandler<PacketSuperRing, IMessage> {
        @Override
        public IMessage onMessage(PacketSuperRing message, MessageContext ctx) {
        	if(message.text.startsWith("set")){
        		EntityPlayer player = ctx.getServerHandler().playerEntity;
        		String[] values = message.text.split(",");
        		SkyMod.setPlayerData(player, Boolean.parseBoolean(values[1]), Boolean.parseBoolean(values[2]), Boolean.parseBoolean(values[3]), Boolean.parseBoolean(values[4]));
        		return new PacketSuperRing("success");
        	}
            return null;
        }
    }
    public static class ClientHandler implements IMessageHandler<PacketSuperRing, IMessage> {
        @Override
        public IMessage onMessage(PacketSuperRing message, MessageContext ctx) {
            return null;
        }
    }
}
