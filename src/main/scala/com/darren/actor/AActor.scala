package com.darren.actor

import akka.actor.{Actor, ActorRef}

/**
  * 乒乓球队员A
  */
class AActor extends Actor {
  override def receive: Receive = {
    case "Start" => println("A: I am Ready")
    case "发球" => {
      println("B: 发球")

      //获取消息发送者sender()
      sender() ! "接球"
    }
  }
}
