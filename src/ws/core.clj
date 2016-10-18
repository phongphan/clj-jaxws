(ns ws.core
  (:import (net.webservicex Currency
                            CurrencyConvertor))
  (:gen-class))

(defn get-conversion-rate [service from-currency to-currency]
  (let [from (Currency/fromValue from-currency)
        to (Currency/fromValue to-currency)]
    (.conversionRate service from to)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [service (CurrencyConvertor.)
        port (.getCurrencyConvertorSoap service)]
    (println (get-conversion-rate port "USD" "GBP"))
    (println (get-conversion-rate port "YUM" "BRL"))
    (println (get-conversion-rate port "ZMK" "NZD"))
    (println (get-conversion-rate port "SDD" "SYP"))
    (println (get-conversion-rate port "SEK" "ZWD"))))
