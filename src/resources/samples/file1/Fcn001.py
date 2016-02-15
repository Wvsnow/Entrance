
import turtle
import random
import time

version = '0.1'

def main():
    tList = []
    head = 0
    numTurtles = 8
    for i in range(numTurtles):
        nt = turtle.Turtle()   # Make a new turtle, initialize values
        nt.setheading(head)
        nt.pensize(2)
        #nt.color(random.randrange(256),random.randrange(256),random.randrange(256))
        nt.color('purple')
        nt.speed(100)
        #nt.tracer(30,0)
        #Have no attribute tracer
        tList.append(nt)       # Add the new turtle to the list
        head = head + 360/numTurtles

    for i in range(60):
        moveTurtles(tList,15,i)
    
    # 绘制矩形
    w = tList[2]
    w.setheading(30)
    w.pensize(8)
    w.speed(10)
    #w.tracer(30,0)
    #Have no attribute tracer
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
    w.color("red")
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
