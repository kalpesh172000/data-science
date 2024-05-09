import scala.io.Source 

object WP {
    def main(args: array[String]): Unit = { //single =
        val file = "WeatherHistory.csv"
        val lines = Source.fromFile(file).getLines()

        //map
        val data = lines.map(line => {
            val fields = line.split(',')
            val temperature = fields(3).toDouble
            val dewPoint = fields(4).toDouble
            val windSpeed = fields(6).toDouble
            (temperature, dewPoint, windSpeed)

        })

        //reduce
        val (tempSum, dewSum, windSum, count) = data.foldLeft((0.0,0.0,0.0,0)) {
            case((tempAcc,dewAcc,windAcc,countAcc),(temperature,dewPoint,windSpeed)) =>
                (tempAcc+temperature,dewAcc+dewPoint,windAcc+windSpeed,countAcc+1)
        }

        val tempMean = tempSum/count
        val dewMean = dewSum / count
        val windMean = windSum / count

        println(s"average temperature is $tempMean")
        println(s"average dew point is $dewMean")
        println(s"average wind speed is $windMean")

    }
}

