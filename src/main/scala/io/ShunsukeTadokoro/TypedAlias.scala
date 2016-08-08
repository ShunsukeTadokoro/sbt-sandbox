package io.ShunsukeTadokoro

/**
 * @author Shunsuke Tadokoro
 */
object TypedAlias {

  type UserId = Long
  type CompanyId = Long

  case class User(userId: UserId, companyId: CompanyId)

  val takashi = User(1, 2)
}
