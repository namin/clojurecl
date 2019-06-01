;;   Copyright (c) Dragan Djuric. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) or later
;;   which can be found in the file LICENSE at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(ns ^{:author "Dragan Djuric"}
    uncomplicate.clojurecl.toolbox
  "Various helpers that are not needed by ClojureCL itself,
  but may be very helpful in applications. See Neanderthal and Bayadera libraries
  for the examples of how to use them."
  (:require [uncomplicate.commons.core :refer [wrap-int]]
   [uncomplicate.clojurecl.core :refer :all]))

(defn count-work-groups ^long [^long max-local-size ^long n]
  (if (< max-local-size n)
    (quot (+ n (dec max-local-size)) max-local-size)
    1))

(defn enq-reduce!
  ([queue main-kernel reduction-kernel n local-n]
   (loop [queue (enq-kernel! queue main-kernel (work-size-1d n local-n))
          global-size (count-work-groups local-n n)]
     (if (= 1 global-size)
       queue
       (recur (enq-kernel! queue reduction-kernel (work-size-1d global-size local-n))
              (count-work-groups local-n global-size)))))
  ([queue main-kernel reduction-kernel m n local-m local-n]
   (if (or (< 1 (long local-n)) (<= (long local-n) (long n)))
     (loop [queue (enq-kernel! queue main-kernel (work-size-2d m n local-m local-n))
            global-size (count-work-groups local-n n)]
       (if (= 1 global-size)
         queue
         (recur (enq-kernel! queue reduction-kernel (work-size-2d m global-size local-m local-n))
                (count-work-groups local-n global-size))))
     (throw (IllegalArgumentException.
             (format "local-n %d would cause infinite recursion for n:%d." local-n n))))))

(defn enq-read-int ^long [queue cl-buf]
  (let [res (int-array 1)]
    (enq-read! queue cl-buf res)
    (aget res 0)))

(defn enq-read-long ^long [queue cl-buf]
  (let [res (long-array 1)]
    (enq-read! queue cl-buf res)
    (aget res 0)))

(defn enq-read-double ^double [queue cl-buf]
  (let [res (double-array 1)]
    (enq-read! queue cl-buf res)
    (aget res 0)))

(defn enq-read-float ^double [queue cl-buf]
  (let [res (float-array 1)]
    (enq-read! queue cl-buf res)
    (aget res 0)))

(defn decent-platform [platforms]
  (first (filter #(< 0 (num-devices % :gpu)) (remove legacy? platforms))))
