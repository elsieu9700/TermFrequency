#!/bin/bash
cd ..
cd src
mv termfreqs.java ../
mv termfreqp.java ../
cd ..
mv termfreqs.java measurement
mv termfreqp.java measurement
cd measurement
javac termfreqs.java
javac termfreqp.java
echo "----------Below This Line is Book1 Time------------"
time java termfreqs A_Tale_of_Two_Cities.txt TermOutput.txt Freq_Out_File.txt
time java termfreqp 4 A_Tale_of_Two_Cities.txt TermOutput.txt Freq_Out_File.txt
echo "----------Below This Line is Book2 Time------------"
time java termfreqs Moby_Dick.txt TermOutput.txt Freq_Out_File.txt
time java termfreqp 4 Moby_Dick.txt TermOutput.txt Freq_Out_File.txt
echo "----------Below This Line is Book3 Time------------"
time java termfreqs Thackeray.txt TermOutput.txt Freq_Out_File.txt
time java termfreqp 4 Thackeray.txt TermOutput.txt Freq_Out_File.txt
mv termfreqs.java ../
mv termfreqp.java ../
cd ..
mv termfreqs.java src
mv termfreqp.java src
