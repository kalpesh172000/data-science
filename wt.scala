import scala.io.Source;

object wt {
    def main(args: Array[String]): Unit = {
        val filename = 'wt.csv'

        val lines = Source.fromFile(filename).getLines()

        val data = lines.map(line => {
            val fields = line.split(',')
            val temp = fields[3].toDouble
            val dew = fields[4].toDouble
            val wind = fields.[6].toDouble
            (temp,dew,wind)
        })

        val (tempsum,dewsum,windsum,count) = data.foldLeft((0.0,0.0,0.0,0)) {
            case ((tempacc,dewacc,windacc,countacc),(temp,dew,wind)) =>
            (tempacc + temp, dewacc + dew, windacc + wind, countacc +1)
        }

        val tempavg = tempsum / count
        val dewavg = dewsum / count
        val windavg = windsum / count

        println(s"temperature is : $tempavg")
        println(s"dewf : $dewavg")
        println(s"wind : $windavg")
    }
}