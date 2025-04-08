package xyz.lncvrt.galaxyapi.utils

@Suppress("unused")
class MessageFormat {
    companion object {
        fun setPrefix(text: String): String {
            return "<bold><gradient:#${Messages.PRIMARY_COLOR}:#${Messages.SECONDARY_COLOR}:#${Messages.PRIMARY_COLOR}>GalaxyNetwork</gradient> <gray>»</gray></bold> $text"
        }

        fun setStaffPrefix(text: String): String {
            return "<bold><gradient:#${Messages.PRIMARY_COLOR}:#${Messages.SECONDARY_COLOR}:#${Messages.PRIMARY_COLOR}>GalaxyNetwork</gradient> <gradient:green:dark_green:green>Staff Mode</gradient> <gray>»</gray></bold> $text"
        }
    }
}
