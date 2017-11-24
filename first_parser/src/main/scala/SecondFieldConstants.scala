object SecondFieldConstants {
  val NEW_COLUMN_NAME = "parse_arg_co"
  private[this] val RECEIVE_TIME = "receive_time"
  private[this] val ARG_DUID = "requests.arg_duid"
  private[this] val ARG_EID = "requests.arg_eid"
  private[this] val ARG_SE_AC = "requests.arg_se_ac"
  private[this] val ARG_SE_CA = "requests.arg_se_ca"
  private[this] val ARG_SE_LA = "requests.arg_se_la"
  private[this] val ARG_SE_PR = "requests.arg_se_pr"
  private[this] val ARG_SE_VA = "requests.arg_se_va"
  private[this] val ARG_UID = "requests.arg_uid"

  private[this] val FIRMWARE_VERSION = NEW_COLUMN_NAME + ".data.data.firmware_version"
  private[this] val PLATFORM = NEW_COLUMN_NAME + ".data.data.platform"
  private[this] val APP_VER = NEW_COLUMN_NAME + ".data.data.app_ver"
  private[this] val LINK = NEW_COLUMN_NAME + ".data.data.link"
  private[this] val SCR_DUR = NEW_COLUMN_NAME + ".data.data.scr_dur"
  private[this] val SCR_IDX = NEW_COLUMN_NAME + ".data.data.scr_idx"
  private[this] val SCR_TYPE = NEW_COLUMN_NAME + ".data.data.scr_type"
  private[this] val SCR_KEY = NEW_COLUMN_NAME + ".data.data.scr_key"
  private[this] val SCR_ID = NEW_COLUMN_NAME + ".data.data.scr_id"
  private[this] val SCR_PATH = NEW_COLUMN_NAME + ".data.data.scr_path"
  private[this] val PL_TIME = NEW_COLUMN_NAME + ".data.data.pl_time"
  private[this] val PL_PAUSE_DUR = NEW_COLUMN_NAME + ".data.data.pl_pause_dur"
  private[this] val PL_VIDEO_LEN = NEW_COLUMN_NAME + ".data.data.pl_video_len"
  private[this] val PL_PCT = NEW_COLUMN_NAME + ".data.data.pl_pct"
  private[this] val PL_SBUFF = NEW_COLUMN_NAME + ".data.data.pl_sbuff"
  private[this] val PL_RBUFF = NEW_COLUMN_NAME + ".data.data.pl_rbuff"
  private[this] val PL_N_BUFF = NEW_COLUMN_NAME + ".data.data.pl_n_buff"
  private[this] val PL_PLAYER = NEW_COLUMN_NAME + ".data.data.pl_player"
  private[this] val AUTO_RUN = NEW_COLUMN_NAME + ".data.data.auto_run"

  val REQUIRED_FIELDS = List(
    RECEIVE_TIME,
    ARG_DUID,
    ARG_EID,
    ARG_SE_AC,
    ARG_SE_CA,
    ARG_SE_LA,
    ARG_SE_PR,
    ARG_SE_VA,
    ARG_UID,
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
    AUTO_RUN)
}
