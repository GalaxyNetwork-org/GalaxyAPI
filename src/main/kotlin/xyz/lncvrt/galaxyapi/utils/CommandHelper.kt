package xyz.lncvrt.galaxyapi.utils

import org.bukkit.entity.Player
import xyz.lncvrt.galaxyapi.GalaxyAPI

@Suppress("unused")
class CommandHelper {
    fun executeAsPlayer(player: Player, command: String) {
        player.performCommand(command)
    }

    fun executeAsConsole(command: String) {
        val instance = GalaxyAPI.getInstance()
        instance.server.dispatchCommand(instance.server.consoleSender, command)
    }
}