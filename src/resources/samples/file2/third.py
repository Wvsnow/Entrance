import turtle
import random
import time
import sys

import math


#import Fcn001     # Error with import Fcn001.py
import mymodule   # Error with import mymodule.py
#from mymodule import multiply,divide  # another Method to use the fcn in out module 



def main():
   i = 5
   print(i)
   i = i + 1
   print('value of i is', i)
   ############### Testing the method of application of string output
   s = '''This is a multi-line string.
   This is the second line.'''
   print(s)
   s = 'This is a string. \
   This continues the string.'
   print(s)

   i = 10**10
   print('i = 10**10 = ', i)

   i = 134
   j = 50
   k = i//j
   print(' i =',i,' j =',j,' k = i//j =',k)
   k = i%j
   print(' i =',i,' j =',j,' k = i%j =',k)
   ############### Testing the method of application of for-loop
   for i in(10,12,33,14,57):
      if ~i%2:
         print(i,'is an even number.')
      else:
         print(i,'is an odd number.')
   for i in range(0, 3):
      print(i)
   else:
      print('The for loop is over with outputting range(0,3)')
   for i in range(0, 300, 98):
      print(i)
   else:
      print('The for loop is over with outputting range(0, 300, 98)')
##   ############### Testing the method of application of while-if
##   number = 23
##   guess = 10
##   while(guess!=number):     
##      guess = int(input('Enter an integer to guess: '))
##      if guess == number:
##          print('Congratulations, you guessed it.') # New block starts here
##          print("(but you do not win any prizes!)") # New block ends here
##      elif guess < number:
##          print('No, it is a little lower than that') # Another block
##          # You can do whatever you want in a block ...
##      else:
##          print('No, it is a little higher than that')
##          # you must have guess > number to reach here
##   else:
##      print('The while loop is over.')
##      # Do anything else you want to do here
##   print('Done')
##   ############### Testing the method of application of break-clause
##   while True:
##      s = input('Enter something until with quit: ')
##      if s == 'quit':
##         break
##      elif len(s) < 3:
##         print('input string is too short to quit')
##         continue
##      print('Length of the string is', len(s))
##   print('Done')
   ############### Testing the method of application of call-funtion
   sayHello()
   printMax(100,321)
   print('maximum(123,142) is',maximum(123,142))
   printMaxDoc(123,142)
   print(printMaxDoc.__doc__)
   help(printMaxDoc)
   help(printMax)
   ############### Testing the method of application of modules
   print('The command line arguments are:')
   for i in sys.argv:
      print(i)
   print('\n\nThe PYTHONPATH is', sys.path, '\n')
   mymodule.sayhi()
   print('mymodule.version is', mymodule.version)
   #Fcn001.main()    # the same behavior with the time import first time
   #print('Fcn001.version is',Fcn001.version)
   print('math.sqrt(10.2) =', math.sqrt(10.2))
   print()
   print('multiply(10,21) is',mymodule.multiply(10,21))
   print('divide(10,21) is',mymodule.divide(10,21))
   print()
   ############### Testing the method of application of intrinsic constant
   if __name__ == '__main__':
      print('This program is being run by itself')
   else:
      print('I am being imported from another module')
   #print(__path__)
   #print(__line__)
   print('current file path is', __file__)
   ############### Testing the method of application of dir() fcn.
   zzz = 99
   newInt = 100
   print('Show the attribute-list of current module as following:')
   print(dir())
   yy = 78
   newString = 'ABC'
   print('Show the attribute-list of current module as following:')
   print(dir())
   del yy
   print('Show the attribute-list of current module as following:')
   print(dir())
   print('Show the attribute-list of sys module as following:')
   #print(dir(sys))
   ############### Testing the method of application of list-data-stucture
   shoplist = ['apple', 'mango', 'carrot', 'banana']
   print('I have', len(shoplist),'items to purchase.')
   print('These items are:') # Notice the comma at end of the line
   print('All the items :')
   for item in shoplist:
      print(item, ' ', ' ', sep='->', end='')
   else:
      print()
   shoplist.append('added001')
   shoplist.append('added002')
   shoplist.append('added001')
   shoplist.append(123123)
   shoplist.append(0.003782)
   sublist = [12,32.132,'ABC',"zyx",31,1323.1231]
   shoplist.append(sublist)
   print('All the items :')
   for item in shoplist:
      print(item, ' ', ' ', sep='->', end='')
   else:
      print()
   print('Output the shoplist : ', shoplist)
   ############### Testing the method of application of tuple (diffrent from list)
   zoo = ('wolf', 'elephant', 'penguin')
   print('Number of animals in the zoo is', len(zoo))
   new_zoo = ('monkey', 'dolphin', zoo)
   print('Number of animals in the new zoo is', len(new_zoo))
   print('All animals in new zoo are', new_zoo)
   print('Animals brought from old zoo are', new_zoo[2])
   print('Last animal brought from old zoo is', new_zoo[2][2])
   age = 22
   name = 'Swaroop'
   print('%s is %d years old' % (name, age))    # tuple mostly are used in print-clause
   print('Why is %s playing with that python?' % name)
   ############### Testing the method of application of key-value pair i.e. dictionary data structure
   ab = {   'Swaroop'   : 'swaroopch@byteofpython.info',
             'Larry'     : 'larry@wall.org',
             'Matsumoto' : 'matz@ruby-lang.org',
             'Spammer'   : 'spammer@hotmail.com'
     }
   print()
   print("Swaroop's address is %s" % ab['Swaroop'])
   # Adding a key/value pair
   ab['Guido'] = 'guido@python.org'
   # Deleting a key/value pair
   del ab['Spammer']
   print('\nThere are %d contacts in the address-book : \n' % len(ab))
   for name, address in ab.items():
      print('Contact %s at %s' % (name, address))
   if 'Guido' in ab: # OR ab.has_key('Guido')
      print("\nGuido's address is %s" % ab['Guido'])
   ############### Testing the method of application of sequence
   shoplist = ['apple', 'mango', 'carrot', 'banana']
   # Indexing or 'Subscription' operation
   print('Item 0 is', shoplist[0])
   print('Item 1 is', shoplist[1])
   print('Item 2 is', shoplist[2])
   print('Item 3 is', shoplist[3])
   print('Item -1 is', shoplist[-1])
   print('Item -2 is', shoplist[-2])
   print('Item -3 is', shoplist[-3])
   print('Item -4 is', shoplist[-4])
   # Slicing on a list
   print('Item 1 to 3 is', shoplist[1:3])
   print('Item 2 to end is', shoplist[2:])
   print('Item 1 to -1 is', shoplist[1:-1])
   print('Item start to end is', shoplist[:])
   # Slicing on a string
   name = 'ABCDefghijk'
   print('characters 1 to 3 in string \'swaroop\' is', name[1:3])
   print('characters 2 to end in string \'swaroop\' is', name[2:])
   print('characters 1 to -1 in string \'swaroop\' is', name[1:-1])
   print('characters start to end in string \'swaroop\' is', name[:])
   ############### Testing the method of application of reference and copy(i.e. ref and copy)
   print('Simple Assignment')
   shoplist = ['apple', 'mango', 'carrot', 'banana']
   mylist = shoplist # mylist is just another name pointing to the same object!
   del shoplist[0]
   print('shoplist is', shoplist)
   print('mylist is', mylist)
   # notice that both shoplist and mylist both print(the same list without
   # the 'apple' confirming that they point to the same object
   print('Copy by making a full slice')
   mylist = shoplist[:] # make a copy by doing a full slice
   del mylist[0] # remove first item
   print('shoplist is', shoplist)
   print('mylist is', mylist)
   ############### Testing the method of application of string (deeper study especially the fucntions)
   name = 'Swaroop' # This is a string object 
   if name.startswith('Swa'):
       print('Yes, the string starts with "Swa"')
   if 'a' in name:
       print('Yes, it contains the string "a"')
   if name.find('war') != -1:
       print('Yes, it contains the string "war"')
   delimiter = '_*_'
   mylist = ['Brazil', 'Russia', 'India', 'China']
   print(delimiter.join(mylist))
   delimiter = ' '
   mylistStr = delimiter.join(mylist)
   mylist2 = mylistStr.split(' ')
   print(mylist2)
   str = ('www...google.com')
   print(str)
   str_split = str.split('.',500)  # To split the primt stirng 2 times, i.e. create two sub-segment
   print(str_split)
   print('    --  A B C-de F  --                    '.strip(), 'End')
   # remove the blank spacing at the both ends of stirng, for more(lstrip,rstrip)
   # To remove the empty value of a sequence
   
   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

   ############### Testing the method of application of

############### ############### ############### 
############### function defination
############### ############### ###############
         
def sayHello():
   print('Hello World!') # block belonging to the function
def printMax(a, b):
   if a > b:
      print(a, 'is maximum')
   else:
      print(b, 'is maximum')
def printMaxDoc(x, y):
   '''Prints the maximum of two numbers.

   The two values must be integers.
   So you'd better use two integers as the parameter of this function.'''
   x = int(x) # convert to integers, if possible
   y = int(y)
   if x > y:
      print(x, 'is maximum')
   else:
      print(y, 'is maximum')
def maximum(x, y):
   if x > y:
      return x
   else:
      return y
############### ############### ############### 
############### function defination
############### ############### ############### 
main()
