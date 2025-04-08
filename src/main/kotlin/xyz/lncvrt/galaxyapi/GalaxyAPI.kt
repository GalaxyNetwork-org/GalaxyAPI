package xyz.lncvrt.galaxyapi

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class GalaxyAPI : JavaPlugin() {
    override fun onEnable() {
        instance = this
    }

    companion object {
        private lateinit var instance: GalaxyAPI

        fun getInstance(): GalaxyAPI {
            return instance
        }
    }
}
