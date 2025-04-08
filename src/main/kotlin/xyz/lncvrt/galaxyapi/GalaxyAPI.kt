package xyz.lncvrt.galaxyapi

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import xyz.lncvrt.galaxyapi.utils.MessageFormat

@Suppress("unused")
class GalaxyAPI : JavaPlugin(), Listener {
    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun test(event: AsyncChatEvent) {
        event.player.sendMessage(MiniMessage.miniMessage().deserialize(MessageFormat.setStaffPrefix("test")))
    }

    companion object {
        private lateinit var instance: GalaxyAPI

        fun getInstance(): GalaxyAPI {
            return instance
        }
    }
}
