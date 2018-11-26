package com.darren.actor

import akka.actor.{Actor, ActorRef}

/**
  *乒乓球队员B
  */
class BActor(val aActorRef: ActorRef) extends Actor{
  override def receive: Receive = {
    case "Start" => {
      println("B: I am Ready")

      aActorRef ! "发球"
    }
    case "接球" => {
      println("A: 接球")
      Thread.sleep(1000)
      aActorRef ! "发球"
    }
  }
}
