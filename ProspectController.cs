using entities.Entities;
using Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApp.Controllers
{
    public class ProspectController : Controller
    {
        ProspectService ps = new ProspectService();
        // GET: Prospect
        public ActionResult Index()
        {
           
            return View(ps.GetAll());
        }

        // GET: Prospect/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Prospect/Create
        public ActionResult Create()
        {

            return View();
        }

        // POST: Prospect/Create
        [HttpPost]
        public ActionResult Create(Prospect p)
        {
            try
            {
                // TODO: Add insert logic here
                ps.Add(p);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Prospect/Edit/5
        public ActionResult Edit(int id)
        {
            return View(ps.GetById(id));
        }

        // POST: Prospect/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Prospect p)
        {
            try
            {
                Prospect pp = ps.GetById(id);
                pp.IdProspect = p.IdProspect;
                pp.NomProspect = p.NomProspect;
                pp.AdresseMail = p.AdresseMail;
                pp.NumeroProspect = p.NumeroProspect;
                pp.typeProspect = p.NumeroProspect;
                pp.operateur = p.operateur;
                ps.Update(pp);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Prospect/Delete/5
        public ActionResult Delete(int id)
        {
            return View(ps.GetById(id));
        }

        // POST: Prospect/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Prospect p)
        {
            try
            {
                // TODO: Add delete logic here
                p = ps.GetById(id);
                ps.Delete(p);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
