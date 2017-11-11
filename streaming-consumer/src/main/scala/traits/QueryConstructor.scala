package traits

trait QueryConstructor {
  private val SEPERATOR = "\t"
  
  def constructQueryFrom(data: String):String = { 
    val fields = data.split(SEPERATOR)
                 .map(field => field.trim.replace("\\", "\\\\").replace("\'", "\\\'").replace("\"", "\\\""))
                 .map(field => s"'${field}'")
                 
                 println(fields.apply(1))
    val stringBuffer = new StringBuffer
    val autoIncrementId = "null, "
    
    stringBuffer.append("INSERT INTO imdb VALUES")
                .append("(")
                .append(autoIncrementId)
                .append(fields.mkString(", "))
                .append(")")
    
    return stringBuffer.toString
  }
}