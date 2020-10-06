#!/bin/bash
cd ../src
mv termfreqs.java ../test
mv termfreqp.java ../test
cd ../test
javac termfreqs.java
javac termfreqp.java
java termfreqs doc1.txt doc1_terms_s.txt doc1_freqs_s.txt &
java termfreqs doc2.txt doc2_terms_s.txt doc2_freqs_s.txt &
java termfreqs doc3.txt doc3_terms_s.txt doc3_freqs_s.txt &
java termfreqp 4 doc1.txt doc1_terms_p.txt doc1_freqs_p.txt &
java termfreqp 4 doc2.txt doc2_terms_p.txt doc2_freqs_p.txt &
java termfreqp 4 doc3.txt doc3_terms_p.txt doc3_freqs_p.txt &

./For_Processmall_Files.sh

mv termfreqs.java ../src
mv termfreqs.class ../src
mv termfreqp.java ../src
mv termfreqp.class ../src

