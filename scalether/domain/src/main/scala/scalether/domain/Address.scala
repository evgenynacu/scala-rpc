package scalether.domain

import java.nio.charset.StandardCharsets

import com.fasterxml.jackson.databind.annotation.{JsonDeserialize, JsonSerialize}
import io.daonomic.rpc.domain.{Binary, Bytes}
import org.web3jold.crypto.Hash
import scalether.domain.jackson.{AddressDeserializer, AddressSerializer}
import scalether.util.Hex

@JsonSerialize(using = classOf[AddressSerializer])
@JsonDeserialize(using = classOf[AddressDeserializer])
case class Address(bytes: Array[Byte]) extends Bytes {
  assert(bytes.length == 20)

  def toBinary: Binary = Binary(bytes)

  def toChecksumString: String = {
    val s = Hex.to(bytes)
    val hash = Hex.to(Hash.sha3(s.getBytes(StandardCharsets.US_ASCII)))
    "0x" + s.zipWithIndex.map {
      case (char, idx) if Character.digit(hash.charAt(idx), 16) >= 8 =>
        char.toUpper
      case (char, _) =>
        char
    }.mkString
  }
}

object Address {
  val ZERO = Address("0x0000000000000000000000000000000000000000")
  val ONE = Address("0x0000000000000000000000000000000000000001")
  val TWO = Address("0x0000000000000000000000000000000000000002")
  val THREE = Address("0x0000000000000000000000000000000000000003")
  val FOUR = Address("0x0000000000000000000000000000000000000004")

  def apply(hex: String): Address =
    new Address(Hex.toBytes(hex))

  def apply(bytes: Bytes): Address =
    new Address(bytes.bytes)
}
