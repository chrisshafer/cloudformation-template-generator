package com.monsanto.arch.cloudformation.model.resource

import com.monsanto.arch.cloudformation.model.{Token, ConditionRef}
import spray.json.{JsonFormat, DefaultJsonProtocol}

/**
 * Created by Tyler Southwick on 11/18/15.
 */
case class `AWS::SQS::Queue`(
                            name : String,
                                    QueueName: Token[String],
                                    DelaySeconds: Token[Int],
                                    MessageRetentionPeriod: Token[Int],
                                    ReceiveMessageWaitTimeSeconds: Token[Int],
                                    VisibilityTimeout: Token[Int],
                                    override val Condition: Option[ConditionRef] = None)
  extends Resource[`AWS::SQS::Queue`] {
  def when(newCondition: Option[ConditionRef] = Condition) = copy(Condition = newCondition)
}

object `AWS::SQS::Queue` extends DefaultJsonProtocol {
  implicit val format: JsonFormat[`AWS::SQS::Queue`] = jsonFormat7(`AWS::SQS::Queue`.apply)
}

