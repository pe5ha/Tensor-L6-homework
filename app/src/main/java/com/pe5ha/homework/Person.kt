package com.pe5ha.homework

data class Person(
    val id: Long,
    val name: String,
    val position: String,
    val phoneNumber: String,
    val email: String,
    val isOnline: Boolean,
    val lastOnline: String,
    val bioInfo: String,
    val achievements: String,
    val photo: Int
) {

    companion object {
        fun getMockPerson() = listOf(
            Person(
                0,
                "Павел Науменко",
                "Android Developer",
                "88005553535",
                "mail@mail.ru",
                true,
                "20.04.22",
                "21 y.o. from St. Petersburg",
                "Домашнее задание по java, тест по java, домашнее задание по kotlin, тест по kotlin, домашнее задание жизненный цикл фрагментов, домашнее задание 4, домашнее задание 5",
                R.drawable.avatar
            ),
            Person(
                1,
                "Павел Науменко 2",
                "Puff Eggcat",
                "88008008000",
                "mmail@mail.ru",
                false,
                "Был в сети 20.04.22",
                "25 y.o.",
                "Домашнее задание по java, тест по java, домашнее задание по kotlin, тест по kotlin, домашнее задание жизненный цикл фрагментов, домашнее задание 4, домашнее задание 5",
                R.drawable.avatar2
            )
        )
    }
}