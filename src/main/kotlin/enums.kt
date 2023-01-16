
//I want to model the 4 cardinal directions
//enums will help me with this
enum class Direction {
    NORTH, EAST, SOUTH, WEST
}

//Enums with values, like for hex color, I want to get RED, it gives me the hex color or RED
//Edit: These are not the real colors
enum class HighlightColor(val value: Int) {
    RED(0xebba34),
    GREEN(0xebba36),
    BLUE(0xebba37)
}

//enums are useful in limiting the set of value coming in/out of API's or data objects