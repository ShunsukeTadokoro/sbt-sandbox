package io.todokr.github

import freestyle.module

/**
  * Created by ShunsukeTadokoro on 2017/06/04.
  */
trait Modules {
  @module trait Application {
    val validation: Validation
    val interaction: Interaction
  }
}
