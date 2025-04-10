package xyz.lncvrt.galaxyapi.utils

@Suppress("unused")
class MessageFormat {
    companion object {
        fun setPrefix(text: String): String {
            return "<bold><gradient:#${Colors.PRIMARY}:#${Colors.SECONDARY}:#${Colors.PRIMARY}>GalaxyNetwork</gradient> <gray>»</gray></bold> $text"
        }

        fun setStaffPrefix(text: String): String {
            return "<bold><gradient:#${Colors.PRIMARY}:#${Colors.SECONDARY}:#${Colors.PRIMARY}>GalaxyNetwork</gradient> <gradient:green:dark_green:green>Staff Mode</gradient> <gray>»</gray></bold> $text"
        }

        fun setPrimaryColor(text: String): String {
            return "<color:#${Colors.SECONDARY}>$text</color>"
        }

        fun setSecondaryColor(text: String): String {
            return "<color:#${Colors.SECONDARY}>$text</color>"
        }
    }
}
