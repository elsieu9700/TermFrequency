#!/bin/bash
cmp doc1_terms.txt doc1_terms_s.txt
cmp doc1_freqs.txt doc1_freqs_s.txt
echo $'\n'
cmp doc2_terms.txt doc1_terms_s.txt
cmp doc2_freqs.txt doc1_freqs_s.txt
echo $'\n'
cmp doc3_terms.txt doc1_terms_s.txt
cmp doc3_freqs.txt doc1_freqs_s.txt
echo $'\n'
cmp doc1_terms.txt doc1_terms_p.txt
cmp doc1_freqs.txt doc1_freqs_p.txt
echo $'\n'
cmp doc2_terms.txt doc1_terms_p.txt
cmp doc2_freqs.txt doc1_freqs_p.txt
echo $'\n'
cmp doc3_terms.txt doc1_terms_p.txt
cmp doc3_freqs.txt doc1_freqs_p.txt
