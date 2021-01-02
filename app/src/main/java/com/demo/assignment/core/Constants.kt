package com.demo.assignment.core

class Constants {

    object API {
        const val ENDPOINT = "https://api.github.com/"
    }

    object DB {
        const val NAME = "demo-app-db"

        object Table {
            object Repo {
                const val NAME = "repo"
            }
        }
    }

}