# Notes to remember while refactoring

Items will decrease in value apart from aged brie and backstage pass for the concert

sellIn is number of days to sell the item

quality is the value of the item

There is a repeated conditional relating to aged brie. Can extract the repeated conditional to a variable.

The sellIn field is also updated in the function updateQuality.
Can change the function name to updateValues?

Concert tickets drop to 0 quality after sellIn date is 0.


