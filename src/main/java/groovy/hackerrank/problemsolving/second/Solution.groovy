package groovy.hackerrank.problemsolving.second

System.in.withReader {
    br ->
        int testCases = br.readLine().toInteger()
        testCases.times {
            List tCase = br.readLine().tokenize()*.toInteger()
            int money = tCase[0]
            int price = tCase[1]
            int bonusRate = tCase[2]

            int totalBought = money / price
            int free = totalBought / bonusRate
            int initialWrapper = totalBought % bonusRate
            int moreFree = (free + initialWrapper) / bonusRate
            int addWrappers = (free + initialWrapper) % bonusRate
            totalBought = totalBought + free + moreFree

            if ((addWrappers + moreFree) > bonusRate) {
                while (addWrappers + moreFree > bonusRate) {
                    totalBought += (addWrappers + moreFree) / bonusRate
                    moreFree = (addWrappers + moreFree) / bonusRate
                    addWrappers = (moreFree + addWrappers) % bonusRate
                }
            }
            println totalBought
        }
}


