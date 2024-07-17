# Delete the Hbase table task2 to recreate it.
disable 'task2'
drop 'task2'

# Create the Hbase table task2.
create 'task2', 'SUBMISSION','STUDENT','SUBJECT','FILES'

# Put/insert information about a student '007'.
put 'task2','student|007','STUDENT:snumber','007'
put 'task2','student|007','STUDENT:fname','James'
put 'task2','student|007','STUDENT:lname','Bond'
put 'task2','student|007','STUDENT:degree','MIT'

# Put/insert information about a student '666'.
put 'task2','student|666','STUDENT:snumber','666'
put 'task2','student|666','STUDENT:fname','Harry'
put 'task2','student|666','STUDENT:lname','Potter'
put 'task2','student|666','STUDENT:degree','BCS'

# Put/insert information about a subject '312'.
put 'task2','subject|312','SUBJECT:code','312'
put 'task2','subject|312','SUBJECT:title','Big Data'
put 'task2','subject|312','SUBJECT:credits','6'

# Put/insert information about a subject '313'.
put 'task2','subject|313','SUBJECT:code','313'
put 'task2','subject|313','SUBJECT:title','Very Big Data'
put 'task2','subject|313','SUBJECT:credits','12'

# Put/insert information about a submission of Assignment 1 for
# Subject 312 by Student '007'.
put 'task2','submission|007|312|assignment|1','SUBMISSION:sdate','01-APR-2017'
put 'task2','submission|007|312|assignment|1','SUBMISSION:esignature','jb'
put 'task2','submission|007|312|assignment|1','SUBMISSION:totalfiles','2'
put 'task2','submission|007|312|assignment|1','SUBMISSION:dayslate','0'
put 'task2','submission|007|312|assignment|1','SUBMISSION:type','assignment'
put 'task2','submission|007|312|assignment|1','SUBMISSION:tnumber','1'
put 'task2','submission|007|312|assignment|1','STUDENT:snumbner','007'
put 'task2','submission|007|312|assignment|1','SUBJECT:code','312'
put 'task2','submission|007|312|assignment|1','FILES:fnumber1','path/file-name1-1'
put 'task2','submission|007|312|assignment|1','FILES:fnumber2','path/file-name1-1'

# Put/insert information about the submission of Assignment 2 for 
# Subject 312 by Student '007'.
put 'task2','submission|007|312|assignment|2','SUBMISSION:sdate','02-APR-2017'
put 'task2','submission|007|312|assignment|2','SUBMISSION:esignature','jb'
put 'task2','submission|007|312|assignment|2','SUBMISSION:totalfiles','2'
put 'task2','submission|007|312|assignment|2','SUBMISSION:dayslate','0'
put 'task2','submission|007|312|assignment|2','SUBMISSION:type','assignment'
put 'task2','submission|007|312|assignment|2','SUBMISSION:tnumber','2'
put 'task2','submission|007|312|assignment|2','STUDENT:snumbner','007'
put 'task2','submission|007|312|assignment|2','SUBJECT:code','312'
put 'task2','submission|007|312|assignment|2','FILES:fnumbner1','path/file-name2-1'
put 'task2','submission|007|312|assignment|2','FILES:fnumber2','path/file-name2-2'

# Put/insert information about the submission of Project 1 for
# Subject 313 by Student '007'.
put 'task2','submission|007|313|project|1','SUBMISSION:sdate','02-APR-2017'
put 'task2','submission|007|313|project|1','SUBMISSION:esignature','jb'
put 'task2','submission|007|313|project|1','SUBMISSION:totalfiles','2'
put 'task2','submission|007|313|project|1','SUBMISSION:dayslate','0'
put 'task2','submission|007|313|project|1','SUBMISSION:type','project'
put 'task2','submission|007|313|project|1','SUBMISSION:tnumber','2'
put 'task2','submission|007|313|project|1','STUDENT:snumbner','007'
put 'task2','submission|007|313|project|1','SUBJECT:code','313'
put 'task2','submission|007|313|project|1','FILES:fnumber1','path/file-name3-1'

# Put/insert information about the submission of Assignment 1 for
# Subject 312 by Student '666'.
put 'task2','submission|666|312|assignment|1','SUBMISSION:sdate','01-APR-2017'
put 'task2','submission|666|312|assignment|1','SUBMISSION:esignature','hp'
put 'task2','submission|666|312|assignment|1','SUBMISSION:totalfiles','2'
put 'task2','submission|666|312|assignment|1','SUBMISSION:dayslate','0'
put 'task2','submission|666|312|assignment|1','SUBMISSION:type','assignment'
put 'task2','submission|666|312|assignment|1','SUBMISSION:tnumber','1'
put 'task2','submission|666|312|assignment|1','STUDENT:snumbner','666'
put 'task2','submission|666|312|assignment|1','SUBJECT:code','312'
put 'task2','submission|666|312|assignment|1','FILES:fnumber1','path/file-name1-1'
put 'task2','submission|666|312|assignment|1','FILES:fnumber2','path/file-name1-1'

# Put/insert information about the submission of Assignment 2 for
# Subject 312 by Student '666'.
put 'task2','submission|666|312|assignment|2','SUBMISSION:sdate','02-APR-2017'
put 'task2','submission|666|312|assignment|2','SUBMISSION:esignature','hp'
put 'task2','submission|666|312|assignment|2','SUBMISSION:totalfiles','2'
put 'task2','submission|666|312|assignment|2','SUBMISSION:dayslate','0'
put 'task2','submission|666|312|assignment|2','SUBMISSION:type','assignment'
put 'task2','submission|666|312|assignment|2','SUBMISSION:tnumber','2'
put 'task2','submission|666|312|assignment|2','STUDENT:snumbner','666'
put 'task2','submission|666|312|assignment|2','SUBJECT:code','312'
put 'task2','submission|666|312|assignment|2','FILES:fnumber1','path/file-name2-1'
put 'task2','submission|666|312|assignment|2','FILES:fnumber2','path/file-name2-2'

# Put/insert information about the submission of Project 1 for
# Subject 313 by Student '666'.
put 'task2','submission|666|313|project|1','SUBMISSION:sdate','02-APR-2017'
put 'task2','submission|666|313|project|1','SUBMISSION:esignature','hp'
put 'task2','submission|666|313|project|1','SUBMISSION:totalfiles','2'
put 'task2','submission|666|313|project|1','SUBMISSION:dayslate','0'
put 'task2','submission|666|313|project|1','SUBMISSION:type','project'
put 'task2','submission|666|313|project|1','SUBMISSION:tnumber','2'
put 'task2','submission|666|313|project|1','STUDENT:snumbner','666'
put 'task2','submission|666|313|project|1','SUBJECT:code','313'
put 'task2','submission|666|313|project|1','FILES:fnumber1','path/file-name3-1'

# Describing the structure of the Hbase table 'task2'
describe 'task2'

# Scan/display the content of the Hbase table 'task2'
scan 'task2'

