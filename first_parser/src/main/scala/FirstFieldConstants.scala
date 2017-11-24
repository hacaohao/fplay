


object FirstFieldConstants {
  private val RECEIVE_TIME = "receive_time"
  private val ARG_DUID = "requests.arg_duid"
  private val ARG_EID = "requests.arg_eid"
  private val ARG_SE_AC = "requests.arg_se_ac"
  private val ARG_SE_CA = "requests.arg_se_ca"
  private val ARG_SE_LA = "requests.arg_se_la"
  private val ARG_SE_PR = "requests.arg_se_pr"
  private val ARG_SE_VA = "requests.arg_se_va"
  private val ARG_UID = "requests.arg_uid"
  //requests.arg_co.data.data
  
  private val FIRMWARE_VERSION = "requests.arg_co.data.data.firmware_version"
  private val PLATFORM = "requests.arg_co.data.data.platform"
  private val APP_VER = "requests.arg_co.data.data.app_ver"
  private val LINK = "requests.arg_co.data.data.link"
  private val SCR_DUR = "requests.arg_co.data.data.scr_dur"
  private val SCR_IDX = "requests.arg_co.data.data.scr_idx"
  private val SCR_TYPE = "requests.arg_co.data.data.scr_type"
  private val SCR_KEY = "requests.arg_co.data.data.scr_key"
  private val SCR_ID = "requests.arg_co.data.data.scr_id"
  private val SCR_PATH = "requests.arg_co.data.data.scr_path"
  private val PL_TIME = "requests.arg_co.data.data.pl_time"
  private val PL_PAUSE_DUR = "requests.arg_co.data.data.pl_pause_dur"
  private val PL_VIDEO_LEN = "requests.arg_co.data.data.pl_video_len"
  private val PL_PCT = "requests.arg_co.data.data.pl_pct"
  private val PL_SBUFF = "requests.arg_co.data.data.pl_sbuff"
  private val PL_RBUFF = "requests.arg_co.data.data.pl_rbuff"
  private val PL_N_BUFF = "requests.arg_co.data.data.pl_n_buff"
  private val PL_PLAYER = "requests.arg_co.data.data.pl_player"
  private val AUTO_RUN = "requests.arg_co.data.data.auto_run"
  
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