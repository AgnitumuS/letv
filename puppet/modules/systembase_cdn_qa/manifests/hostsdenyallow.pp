class systembase_cdn_qa::hostsdenyallow{
  file{"/etc/hosts.allow":
    ensure => file,
    mode   => 644,
    content => template("systembase_cdn_qa/hosts.allow"),
  }

  file{"/etc/hosts.deny":
    ensure => file,
    mode   => 644,
    content => template("systembase_cdn_qa/hosts.deny"),
  }
}
