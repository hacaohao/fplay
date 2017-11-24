


import scala.collection.Seq

object TransformFields {
  private val FIRMWARE_VERSION = "firmware_version"
  private val PLATFORM = "platform"
  private val APP_VER = "app_ver"
  private val LINK = "link"
  private val SCR_DUR = "scr_dur"
  private val SCR_IDX = "scr_idx"
  private val SCR_TYPE = "scr_type"
  private val SCR_KEY = "scr_key"
  private val SCR_ID = "scr_id"
  private val SCR_PATH = "scr_path"
  private val PL_TIME = "pl_time"
  private val PL_PAUSE_DUR = "pl_pause_dur"
  private val PL_VIDEO_LEN = "pl_video_len"
  private val PL_PCT = "pl_pct"
  private val PL_SBUFF = "pl_sbuff"
  private val PL_RBUFF = "pl_rbuff"
  private val PL_N_BUFF = "pl_n_buff"
  private val PL_PLAYER = "pl_player"
  private val AUTO_RUN = "auto_run"
  
  val REQUIRED_FIELDS = Seq(
      FIRMWARE_VERSION,
      PLATFORM,
      APP_VER,
      LINK,
      SCR_DUR,
      SCR_ID,
      SCR_IDX,
      SCR_KEY,
      SCR_PATH,
      SCR_TYPE,
      PL_N_BUFF,
      PL_PAUSE_DUR,
      PL_PCT,
      PL_PLAYER,
      PL_RBUFF,
      PL_SBUFF,
      PL_TIME,
      PL_VIDEO_LEN,
      AUTO_RUN
  )
}