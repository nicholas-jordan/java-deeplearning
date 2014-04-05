Deep Learning for Java
=======================

Deep learning is a form of state-of-the-art machine learning that can learn to recognize patterns in data unsupervised.

Unsupervised pattern recognition saves time during data analysis, trend discovery and labeling of certain types of data, such as images, text, sound and time series.

[![Build Status](https://api.travis-ci.org/agibsonccc/java-deeplearning.png)](https://api.travis-ci.org/agibsonccc/java-deeplearning).

See [Deeplearning4j.org](http://deeplearning4j.org/) for applications, tutorials, definitions and other resources on the discipline.


Feature set summary
====================

1. Distributed deep learning via Akka clustering and distributed coordination of jobs via Hazelcast with configurations stored in Apache Zookeeper.

2. Various data-preprocessing tools, such as an image loader that allows for binarization, scaling of pixels, normalization via zero-unit mean and standard deviation.

3. Deep-belief networks for both continuous and binary data.

4. Native matrices via Jblas, a Fortran library for matrix computations.

5. Automatic cluster provisioning for Amazon Web Services' Elastic Compute Cloud (EC2).

6. Baseline ability to read from a variety of input providers including S3 and local file systems.

7. Text processing via Word2Vec as well as a term frequency–inverse document frequency (TFIDF) vectorizer.
          
  - Special tokenizers/stemmers and a SentenceIterator interface to make handling text input agnostic.
  - Ability to do moving-window operations via a Window encoding. Optimized with Viterbi.


Neural net knobs supported
=====================================
         L2 Regualarization
         Dropout
         Adagrad
         Momentum
         Optimization algorithms for training (Conjugate Gradient, Stochastic Gradient Descent)
         Different kinds of activation functions (Tanh, Sigmoid, HardTanh, Softmax)
         Normalization by input rows, or not
         Sparsity (force activations of sparse/rare inputs)
         Weight transforms (useful for deep autoencoders)
         Different kinds of loss functions - squared loss, reconstruction cross entropy, negative log likelihood
         Probability distribution manipulation for initial weight generation



Coming up
=============================

Recursive neural nets, convolutional neural nets and a recursive neural tensor.

Matrix-provider agnostic: 

A matrix-abstraction layer that sits atop various matrix providers which will allow for 
distributed GPU deep learning via either AMD, NVIDIA or native with BLAS, as well as bindings for Colt for plain old Java abstraction layers used in tasks such as face detection, named-entity recognition and sentiment analysis.

# Maven coordinates

## Singular neural nets
       
       <dependency>
        <groupId>org.deeplearning4j</groupId>
        <artifactId>deeplearning4j-core</artifactId>
         <version>0.0.3.1</version>
      </dependency>


## Scaleout for multithreaded methods and clustering
       
        <dependency>
         <groupId>org.deeplearning4j</groupId>
           <artifactId>deeplearning4j-scaleout-akka</artifactId>
         <version>0.0.3.1</version>
        </dependency>



## Text analysis

         <dependency>
           <groupId>org.deeplearning4j</groupId>
            <artifactId>deeplearning4j-scaleout-akka-word2vec</artifactId>
             <version>0.0.3.1</version>
          </dependency>


