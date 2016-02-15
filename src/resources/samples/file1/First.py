
import turtle
import random
import time

def main():
    tList = []
    head = 0
    numTurtles = 8
    for i in range(numTurtles):
        nt = turtle.Turtle()   # Make a new turtle, initialize values
        nt.setheading(head)
        nt.pensize(2)
        nt.color(random.randrange(256),random.randrange(256),random.randrange(256))
        nt.speed(10)
        nt.tracer(30,0)
        tList.append(nt)       # Add the new turtle to the list
        head = head + 360/numTurtles

    for i in range(100):
        moveTurtles(tList,15,i)
    
    # 绘制矩形
    w = tList[2]
    w.setheading(30)
    w.pensize(8)
    w.speed(10)
    w.tracer(30,0)
    w.up()
    w.goto(0,0)
    w.color("red")
    w.write("O")
    w.pensize(2)
    w.color("purple")
    length = 120
    w.goto(length,length)
    w.down()
    w.goto(length,-length)
    w.goto(-length,-length)
    w.goto(-length,length)
    w.goto(length,length)
    w.up()
    w.goto(0,160)
    w.down()
    w.right(100)
    # 五边形五角星
    w.up()
    w.color(128,0,0)
    w.pensize(3)
    w.goto(0,0)
    w.down()
    w.speed(10)
    for i in range(6):
        w.forward(180)
        w.right(144)
    w.up()
    w.goto(-50,100)
    w.setheading(0)
    w.down()
    for i in range(6):
        w.forward(100)
        w.right(72)
    w.up()
    w.forward(100)
    w.goto(-150,-120)
    w.color("red")
    w.write("Done")
    
    
def moveTurtles(turtleList,dist,angle):
    for turtle in turtleList:   # Make every turtle on the list do the same actions.
        turtle.forward(dist)
        turtle.right(angle)

main()