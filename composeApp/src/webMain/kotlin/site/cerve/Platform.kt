package site.cerve

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform