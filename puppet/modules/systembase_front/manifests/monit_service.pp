class systembase_front::monit_service {
  service{ "monit":
    ensure     => running,
    hasstatus  => false,
    hasrestart => false,
    subscribe  => Class["systembase_front::monit_config"],
    start      => "sleep 2 ;/usr/bin/monit;/usr/bin/monit monitor all",
#    restart    => "/usr/bin/monit reload",
    stop       => "/usr/bin/monit quit",
  }
}
