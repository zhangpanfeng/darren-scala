package com.darren.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class HelloActor extends Actor {
  //接收消息
  override def receive: Receive = {
    case "你好帅" => println("我喜欢你这种人")
    case "你好丑" => println("滚犊子")
    case "stop" => {
      //关闭自己
      context.stop(self)
      //关闭工厂
      context.system.terminate()
    }
  }
}

object HelloActor {

  //工厂
  private val nBFactor = ActorSystem("NBFactor")
  private val helloActorRef: ActorRef = nBFactor.actorOf(Props[HelloActor], "helloActor")

  def main(args: Array[String]): Unit = {

    helloActorRef ! "你好帅"
    helloActorRef ! "你好丑"
    //发送停止消息
    helloActorRef ! "stop"
  }
}