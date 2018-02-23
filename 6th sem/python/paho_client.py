
import paho.mqtt.client as mqtt

 
# Define event callbacks
def on_connect(client, userdata, flags, rc):
    print("rc: " + str(rc))
 
def on_message(client, obj, msg):
    print(msg.topic + " " + str(msg.qos) + " " + str(msg.payload))
 
 
 
def on_subscribe(client, obj, mid, granted_qos):
    print("Subscribed: " + str(mid) + " " + str(granted_qos))
 
def on_log(client, obj, level, string):
    print(string)
 
mqttc = mqtt.Client()
# Assign event callbacks
mqttc.on_message = on_message
mqttc.on_connect = on_connect
 
mqttc.on_subscribe = on_subscribe
 
topic = 'test'
 
# Connect
#mqttc.username_pw_set(user, password)
mqttc.username_pw_set('ijgkqtth', '5VkJJ8qL9jPk')
#mqttc.connect(server, port)
mqttc.connect('m14.cloudmqtt.com', 12694)
 
# Start subscribe, with QoS level 0
mqttc.subscribe(topic, 0)
# Continue the network loop, exit when an error occurs
rc = 0
while rc == 0:
    rc = mqttc.loop()
