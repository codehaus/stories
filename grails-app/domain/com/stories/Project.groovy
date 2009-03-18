package com.stories

class Project {

  String key
  String name
  String description

  static hasMany = [iterations : Iteration]

  static constraints = {
  }

  String toString() {
    return "$key - $name"
  }

}
