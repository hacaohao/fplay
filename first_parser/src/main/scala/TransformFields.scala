import scala.collection.Seq

object TransformFields {
  private[this] val FIRMWARE_VERSION = "firmware_version"
  private[this] val PLATFORM = "platform"
  private[this] val APP_VER = "app_ver"
  private[this] val LINK = "link"
  private[this] val SCR_DUR = "scr_dur"
  private[this] val SCR_IDX = "scr_idx"
  private[this] val SCR_TYPE = "scr_type"
  private[this] val SCR_KEY = "scr_key"
  private[this] val SCR_ID = "scr_id"
  private[this] val SCR_PATH = "scr_path"
  private[this] val PL_TIME = "pl_time"
  private[this] val PL_PAUSE_DUR = "pl_pause_dur"
  private[this] val PL_VIDEO_LEN = "pl_video_len"
  private[this] val PL_PCT = "pl_pct"
  private[this] val PL_SBUFF = "pl_sbuff"
  private[this] val PL_RBUFF = "pl_rbuff"
  private[this] val PL_N_BUFF = "pl_n_buff"
  private[this] val PL_PLAYER = "pl_player"
  private[this] val AUTO_RUN = "auto_run"

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
