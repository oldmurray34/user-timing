fun correctWord (timeSinceOnline: Int, timeKind: String): String {
    return if (timeKind == "min") {
        println((timeSinceOnline / 60) % 10)
        when (timeSinceOnline / 60 % 10) {
            1 -> "минуту"
            2, 3, 4 -> "минуты"
            else -> "минут"
        }
    } else {
        when (timeSinceOnline / 3600 % 10) {
            1 -> "день"
            2, 3, 4 -> "дня"
            else -> "дней"
        }
    }
}

fun showWhenLastSeen(timeSinceOnline: Int): String {
    return when (timeSinceOnline) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${timeSinceOnline / 60} ${correctWord(timeSinceOnline, timeKind = "min")} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${timeSinceOnline / 3600} ${
            correctWord(
                timeSinceOnline,
                timeKind = "day"
            )
        } назад"
        in 24 * 60 * 60..24 * 60 * 60 * 2 -> "сегодня"
        in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "вчера"
        else -> "давно"
    }
}