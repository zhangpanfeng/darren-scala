package com.darren.actor

import akka.actor.{ActorRef, ActorSystem, Props}

object PingPangApp extends App {

  private val pingPangActorSystem = ActorSystem("pingPangActor")
  //通过actorSystem 创建actorRef

  //创建队员A的actorRef
  private val aActorRef: ActorRef = pingPangActorSystem.actorOf(Props[AActor], "A")
  //创建队员B的actorRef
  private val bActorRef: ActorRef = pingPangActorSystem.actorOf(Props(new BActor(aActorRef)), "B")

  bActorRef ! "Start"
  aActorRef ! "Start"
  //  def main(args: Array[String]): Unit = {
  //
  //  }
}
