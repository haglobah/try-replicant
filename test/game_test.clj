(ns game-test
  (:require  [clojure.test :refer [deftest is testing]]
             [tic-tac-toe.game :as game]))

(deftest tic-tac-toe-test
  (testing "X is the starting player"
    (is (= (game/create-game {:size 3})
           {:next-player :x
            :size 3})))
  (testing "X places a tic"
    (is (= (-> (game/create-game {:size 3})
               (game/tic 0 0))
           {:size 3
            :tics {[0 0] :x}
            :next-player :o})))
  (testing "X places a tic"
    (is (= (-> (game/create-game {:size 3})
               (game/tic 0 0)
               (game/tic 0 1))
           {:size 3
            :tics {[0 0] :x
                   [0 1] :o}
            :next-player :x})))
  (testing "Can't tic-tac on the same spot"
    (is (= (-> (game/create-game {:size 3})
               (game/tic 0 0)
               (game/tic 0 0))
           {:size 3
            :next-player :o
            :tics {[0 0] :x}})))
  (testing "Can't tic outside the board"
    (is (= (-> (game/create-game {:size 3})
               (game/tic 3 0))
           {:size 3
            :next-player :x}))

    (is (= (-> (game/create-game {:size 3})
               (game/tic 0 3))
           {:size 3
            :next-player :x}))))
