# User Guide
Duke is a **desktop app for managing calendar checklist, optimized for use via a Command Line Interface** (CLI). 
If you can type fast, this can get your checklist done faster than traditional GUI apps.

## Features 

### Add tasks into the list
There are 3 type of tasks that can be added into the list  
* `Todo` -  tasks that do not have any date/time attach  
* `Event` - tasks that start at a specific time and ends at a specific time
* `Deadline` - tasks that need to be done before a specific date/time.  


Tasks added will be saved in a text file so that even if the program is restarted 
added tasks will remain in the task list.

### List down all the tasks
List out all the tasks in the task list with their index, type, completion status and deadline/date(if applicatble)

### Delete tasks from the list
Remove tasks that are no longer relevant/ wrongly keyed from the list

### Mark task as done
Change the completion status of the task to done so that user can have a sense of which task have been completed

### Find task from list
Search for a specific task by the name/section of the task.

## Usage

### `todo TASK` - Add a new todo task

Add a task that do not have any date/time attach to it into the list

Example of usage: 

`todo borrow book`

Expected outcome:
<pre>
`    ____________________________________________________________
     Got it. I've added this task:
         [T][✘] borrow book
     Now you have 1 tasks in the list.
     ____________________________________________________________
</pre>

<br/>

### `event EVENT /at TIME` - Add a new event task

Add a task that start at a specific time and ends at a specific time

Example of usage: 

event project meeting /at Mon 2-4pm

Expected outcome:
<pre>
    ____________________________________________________________
    Got it. I've added this task:
        [E][✘] project meeting (at: Mon 2-4pm)
    Now you have 2 tasks in the list.
    ____________________________________________________________
</pre>

<br/>

### `deadline TASK /by TIME` - Add a new deadline task

Add a task that need to be done before a specific date/time.
TIME need to be in the format of (dd/MM/yyyy hhmm) in 24hr clock 

Example of usage: 

deadline submit report /by 11/10/2019 1700

Expected outcome:
<pre>
        ____________________________________________________________
        Got it. I've added this task:
            [D][✘] submit report (by: Oct 11 2019 05:00 PM)
        Now you have 3 tasks in the list.
        ____________________________________________________________
</pre>

<br/>
<br/>

### `list` - Display stored tasks

Display all the tasks stored with their index, task type, completion status, task name and time if applicable

Example of usage: 

list

Expected outcome:
<pre>
            ____________________________________________________________
            Here are the tasks in your list:
            1.[T][✘] borrow book
            2.[E][✘] project meeting (at: Mon 2-4pm)
            3.[D][✘] submit report (by: Oct 11 2019 05:00 PM)
            ____________________________________________________________
</pre>

<br/>

### `done INDEX` - Mark a task as completed

Mark an uncompleted task as completed.  
INDEX correspond to the index of the task in the list

Example of usage: 

done 1

Expected outcome:
<pre>
    ____________________________________________________________
    Nice! I've marked this task as done:
    [✓] borrow book
    ____________________________________________________________
</pre>

<br/>

### `delete INDEX` - Delete a task from the list

Delete a task from the list as well as from the storage file  
INDEX correspond to the index of the task in the list

Example of usage: 

done 1

Expected outcome:
<pre>
    ____________________________________________________________
    Noted. I've removed this task:
    [T][✓] borrow book
    Now you have 2 tasks in the list.
    ____________________________________________________________
</pre>

<br/>

### `find KEY` - Search for tasks contain the key words

Search for tasks from the list that contain KEY

Example of usage: 

find meeting

Expected outcome:
<pre>
    ____________________________________________________________
    Here are the matching tasks in your list:
    1.[E][✘] project meeting (at: Mon 2-4pm)
    ____________________________________________________________
</pre>
