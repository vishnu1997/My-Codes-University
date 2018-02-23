
import paho.mqtt.client as mqtt

 
# Define event callbacks
def on_connect(client, userdata, flags, rc):
    print("rc: " + str(rc))
 
def on_message(client, obj, msg):
    print(msg.topic + " " + str(msg.qos) + " " + str(msg.payload))
 
def on_publish(client, obj, mid):
    print("mid: " + str(mid))
 
def on_log(client, obj, level, string):
    print(string)
 
mqttc = mqtt.Client()
# Assign event callbacks
mqttc.on_message = on_message
mqttc.on_connect = on_connect
mqttc.on_publish = on_publish
 
topic = 'test'
 
# Connect
#mqttc.username_pw_set(user, password)
mqttc.username_pw_set('ijgkqtth', '5VkJJ8qL9jPk')
#mqttc.connect(server, port)
mqttc.connect('m14.cloudmqtt.com', 12694)
 
# Star
 
# Publish a message
mqttc.publish(topic, "ytfgyuv")