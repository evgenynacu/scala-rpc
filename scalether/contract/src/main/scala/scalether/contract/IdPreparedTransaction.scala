package scalether.contract

import java.math.BigInteger

import cats.Id
import io.daonomic.cats.implicits._
import io.daonomic.rpc.domain.{Binary, Word}
import scalether.abi.Signature
import scalether.abi.tuple.TupleType
import scalether.domain.Address
import scalether.transaction.IdTransactionSender

class IdPreparedTransaction[O](address: Address,
                               out: TupleType[O],
                               data: Binary,
                               sender: IdTransactionSender,
                               value: BigInteger,
                               gas: BigInteger = null,
                               gasPrice: BigInteger = null,
                               from: Address = null)
  extends PreparedTransaction[Id, O](address, out, data, sender, value, gas, gasPrice, from) {

  override def withGas(newGas: BigInteger): IdPreparedTransaction[O] =
    new IdPreparedTransaction[O](address, out, data, sender, value, newGas, gasPrice, from)

  override def withGasPrice(newGasPrice: BigInteger): IdPreparedTransaction[O] =
    new IdPreparedTransaction[O](address, out, data, sender, value, gas, newGasPrice, from)

  override def withValue(newValue: BigInteger): IdPreparedTransaction[O] =
    new IdPreparedTransaction[O](address, out, data, sender, newValue, gas, gasPrice, from)

  override def withFrom(newFrom: Address): IdPreparedTransaction[O] =
    new IdPreparedTransaction[O](address, out, data, sender, value, gas, gasPrice, newFrom)

  override def call(): O = super.call()

  override def execute(): Word = super.execute()

  override def estimate(): BigInteger = super.estimate()

  override def estimateAndExecute(): Word = super.estimateAndExecute()
}

object IdPreparedTransaction {
  def apply[I, O](address: Address,
                  signature: Signature[I, O],
                  in: I,
                  sender: IdTransactionSender,
                  value: BigInteger = null,
                  gas: BigInteger = null,
                  gasPrice: BigInteger = null,
                  from: Address = null): IdPreparedTransaction[O] =
    new IdPreparedTransaction[O](address, signature.out, signature.encode(in), sender, value, gas, gasPrice, from)
}