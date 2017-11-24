object FirstFieldConstants {
  private[this] val RECEIVE_TIME = "receive_time"
  private[this] val ARG_DUID = "requests.arg_duid"
  private[this] val ARG_EID = "requests.arg_eid"
  private[this] val ARG_SE_AC = "requests.arg_se_ac"
  private[this] val ARG_SE_CA = "requests.arg_se_ca"
  private[this] val ARG_SE_LA = "requests.arg_se_la"
  private[this] val ARG_SE_PR = "requests.arg_se_pr"
  private[this] val ARG_SE_VA = "requests.arg_se_va"
  private[this] val ARG_UID = "requests.arg_uid"
  //requests.arg_co.data.data

  private[this] val FIRMWARE_VERSION = "requests.arg_co.data.data.firmware_version"
  private[this] val PLATFORM = "requests.arg_co.data.data.platform"
  private[this] val APP_VER = "requests.arg_co.data.data.app_ver"
  private[this] val LINK = "requests.arg_co.data.data.link"
  private[this] val SCR_DUR = "requests.arg_co.data.data.scr_dur"
  private[this] val SCR_IDX = "requests.arg_co.data.data.scr_idx"
  private[this] val SCR_TYPE = "requests.arg_co.data.data.scr_type"
  private[this] val SCR_KEY = "requests.arg_co.data.data.scr_key"
  private[this] val SCR_ID = "requests.arg_co.data.data.scr_id"
  private[this] val SCR_PATH = "requests.arg_co.data.data.scr_path"
  private[this] val PL_TIME = "requests.arg_co.data.data.pl_time"
  private[this] val PL_PAUSE_DUR = "requests.arg_co.data.data.pl_pause_dur"
  private[this] val PL_VIDEO_LEN = "requests.arg_co.data.data.pl_video_len"
  private[this] val PL_PCT = "requests.arg_co.data.data.pl_pct"
  private[this] val PL_SBUFF = "requests.arg_co.data.data.pl_sbuff"
  private[this] val PL_RBUFF = "requests.arg_co.data.data.pl_rbuff"
  private[this] val PL_N_BUFF = "requests.arg_co.data.data.pl_n_buff"
  private[this] val PL_PLAYER = "requests.arg_co.data.data.pl_player"
  private[this] val AUTO_RUN = "requests.arg_co.data.data.auto_run"

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
    AUTO_RUN
  )
}
