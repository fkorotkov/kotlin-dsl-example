package com.github.fkorotkov.examples.kubernetes

import com.fkorotkov.kubernetes.client.DefaultKafkaClient
import com.fkorotkov.kubernetes.client.DefaultZookeeperClient
import com.fkorotkov.kubernetes.kafka.*

fun main() {
    val kafkaClient = DefaultKafkaClient().inNamespace("operator")
    println(kafkaClient.kafkaClusters().list())
    kafkaClient.kafkaClusters().create(
        newKafkaCluster {
            metadata {
                name = "kafka"
            }
            spec {
                replicas = 3
            }
        }
    )
    println(kafkaClient.kafkaClusters().list())


  val zookeeperClient = DefaultZookeeperClient().inNamespace("operator")
  println(zookeeperClient.zookeeperClusters().list())
}
