package com.stories

class Iteration {

  String key
  String name
  Date startDate
  Date endDate
  String description

  Project project  

    static constraints = {
    }

  String toString() {
    return "$key - $name"
  }
}
