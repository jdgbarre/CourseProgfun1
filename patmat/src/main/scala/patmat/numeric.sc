val string1 = "4,23"
val string2 = "4.23"
val string3 = "Port"
val string4 = "192.168.0.1"

val regex1 = """^-?(?!0)(?:\d+|\d{1,3}(?:\.\d{3})+)$"""
val regex2: String = """\.|\,"""

val n1 = string1.split(regex2)
val n2 = string2.split(regex2)
val n3 = string3.split(regex2)
val n4 = string4.split(regex2)

def numeric(s: String, regex: String): Any = s split regex length match {
  case 2 => BigDecimal(s.split(regex)(0)) + BigDecimal("0." + s.split(regex) (1))
  case _ => s
}

numeric(string1, regex2)
numeric(string2, regex2)
numeric(string3, regex2)
numeric(string4, regex2)

def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

isPrime(1)
isPrime(13)
isPrime(24)
